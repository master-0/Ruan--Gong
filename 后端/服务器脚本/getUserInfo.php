<?php
	$file_path = "/home/python_project/file/".$_GET['userAccount'].".txt";
	if(file_exists($file_path)){
		$str = file_get_contents($file_path);//将整个文件内容读入到一个字符串中
		$str = str_replace("\r\n","<br />",$str);
		echo $str;
	}
?>
