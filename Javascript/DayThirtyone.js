function radixSortUint32(input) {
  const arrayConstr = input.length < (1 << 16) ?
    Uint16Array :
    Uint32Array;
  const numberOfBins = 256 * 4;
  let count = new arrayConstr(numberOfBins);

  let output = new Uint32Array(input.length);

  // count all bytes in one pass
  for (let i = 0; i < input.length; i++) {
    let val = input[i];
    count[val & 0xFF]++;
    count[((val >> 8) & 0xFF) + 256]++;
    count[((val >> 16) & 0xFF) + 512]++;
    count[((val >> 24) & 0xFF) + 768]++;
  }

  // create summed array
  for (let j = 0; j < 4; j++) {
    let t = 0,
      sum = 0,
      offset = j * 256;
    for (let i = 0; i < 256; i++) {
      t = count[i + offset];
      count[i + offset] = sum;
      sum += t;
    }
  }

  for (let i = 0; i < input.length; i++) {
    let val = input[i];
    output[count[val & 0xFF]++] = val;
  }
  for (let i = 0; i < input.length; i++) {
    let val = output[i];
    input[count[((val >> 8) & 0xFF) + 256]++] = val;
  }
  for (let i = 0; i < input.length; i++) {
    let val = input[i];
    output[count[((val >> 16) & 0xFF) + 512]++] = val;
  }
  for (let i = 0; i < input.length; i++) {
    let val = output[i];
    input[count[((val >> 24) & 0xFF) + 768]++] = val;
  }

  return input;
}
