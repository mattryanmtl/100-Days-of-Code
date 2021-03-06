function day33 (array, i, j) {
    if (j === undefined) {
        j = array.length - 1;
    }
 
    if (i === undefined) {
        i = 0;
    }
 
    if (array[j] < array[i]) {
        var aux = array[i];
        array[i] = array[j];
        array[j] = aux;
    }
 
    if (j - i > 1) {
        var t = Math.floor((j - i + 1) / 3);
        day33(array, i, j-t);
        day33(array, i+t, j);
        day33(array, i, j-t);
    }
};

arr = [13,9,60,43,2,39,54,87];
day33(arr);
console.log(arr);
