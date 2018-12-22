<?php
require "conn.php";
$user_name = $_POST["user_name"];
$user_password= $_POST["password"];
$mysql_qry = "select * from user_registration where email like '$user_name' and password like '$user_password';";
$result = mysqli_query($conn, $mysql_qry);
if (mysqli_num_rows($result) > 0){
    
    while($row = mysqli_fetch_array($result)){
        $flag[] = $row;
    }
    echo (json_encode($flag));
}
else {
    echo json_encode(("login failed"));
}
$conn->close();
?>