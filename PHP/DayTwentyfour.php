<?php
function shell_sort(&$a) {
    $count = count($a);

    $columns = 1;
    while ($columns < $count) {
        $columns = $columns * 2 + 1;
    }

    $columns = ($columns - 1) / 2;
    while ($columns > 0) {
        for ($c = 0; $c < $columns; $c++) {
            for ($i = $columns; $i < $count; $i += $columns) {
                $value = $a[$i];
                for ($x = $i - $columns;( ($x >= 0) && ($a[$x] > $value) );
                        $x -= $columns) {
                    $a[$x + $columns] = $a[$x];
                }
                $a[$x + $columns] = $value;
            }
        }
        $columns = ($columns - 1) / 2;
    }
}

$values = array(8, 2, 5, 9, 1);

shell_sort($values);

foreach ($values as $v) { echo "{$v} "; }
?>
