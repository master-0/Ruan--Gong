<?php
        date_default_timezone_set('Asia/Shanghai');
        $content = date("Y-m-d H:i:s").':'.$_GET['content'].PHP_EOL;
        $myfile = fopen("./exception.txt", "a") or die("Unable to open file!");
        fwrite($myfile, $content);
        fwrite($myfile, PHP_EOL);
        fclose($myfile);
        echo $content
?>
