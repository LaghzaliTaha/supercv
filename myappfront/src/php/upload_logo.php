<?php
$o=new stdClass();
$h=getallheaders();
$source=file_get_contents('php://input');
$types=Array('image/png','image/gif','image/jpeg');
if(!in_array($h['x-file-type'],$types)){
 $o->error="format non suporter";
}
else
{
    file_put_contents( 'logo/'.$h['x-file-name'],$source);
    $o->name="php/logo/".$h['x-file-name'];

}
echo json_encode($o);
?>