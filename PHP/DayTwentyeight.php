<?php
$RANGE = 255;
 
function day28($arr)
{
    global $RANGE;
     
    $output = array(strlen($arr));
    $len = strlen($arr);
     
    $count = array_fill(0, $RANGE + 1, 0);

    for($i = 0; $i < $len; ++$i)
        ++$count[ord($arr[$i])];
 
    for ($i = 1; $i <= $RANGE; ++$i)
        $count[$i] += $count[$i - 1];
 
    for ($i = $len-1; $i >= 0 ; $i--)
    {
        $output[$count[ord($arr[$i])] - 1] = $arr[$i];
        --$count[ord($arr[$i])];
    }
 
    for ($i = 0; $i < $len; ++$i)
        $arr[$i] = $output[$i];
return $arr;
}
 
$arrChar = "Cichorium intybus";
$arrNum = "4568834218790654356732177654982678";
 
$arrChar = day28($arrChar);
$arrNum = day28($arrNum);
 
echo "Sorted character array is " . $arrChar;
echo "<br>";
echo "Sorted integer array is " . $arrNum;
 
?>
