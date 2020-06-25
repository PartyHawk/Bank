<?php

$firstKey = "";
//print "<h2>" .$firstKey. "</h2>";

$myfile = fopen("test.txt", "r") or die("Unable to open file!");
//echo fgets($myfile);
$x = fgets($myfile);
fclose($myfile);

if(!empty($_GET['code'])){
    echo $_GET['code'];
} else {
header('Location: http://145.24.222.224/website/index.php?source=77.248.124.54/php/test.php&cardnumber='. $x .'&request=login'); //verander de ?source = naar de path waar je file word bereikt.
}

/*
foreach ($_POST as $key => $value) {
echo "test";
echo $key;
echo $value;
    switch ($key) {
        case 'firstKey':
        echo "test2";
           // $firstKey = $value;
            $firstKey = "waarde";
            break;
        case 'secondKey':
        echo "test3";
            $secondKey = $value;
            echo $secondKey;
            break;
        default:
            break;
    }
}

$firstKey = "value";
print "<h2>" .$firstKey. "</h2>";
*/
?>