<?php
function insertion_sort(&$a) {
    $count = count($a);
    for ($i = 0; $i < $count; $i++) {
        $value = $a[$i];

        for ($x = $i - 1; ( ($x >= 0) && ($a[$x] > $value) ); $x--) {
            $a[$x + 1] = $a[$x];
        }
        $a[$x + 1] = $value;
    }
}

$values = array(2, 8, 4, 7, 6);

insertion_sort($values);

foreach ($values as $v) { echo "{$v} "; }
?>
