var dayOne = function (nums, target) {
  var sum = {}
  for (var i = 0; i < nums.length; i++) {
    if (!Object.prototype.hasOwnProperty.call(sum, (target - nums[i]))) {
      sum[nums[i]] = i
    } else {
      return [i, sum[target - nums[i]]]
    }
  }
}

console.log(dayOne([2, 7, 11, 15], 9))
