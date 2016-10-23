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
    file_put_contents( 'photoProfil/'.$h['x-file-name'],$source);
    $size = GetImageSize('photoProfil/'.$h['x-file-name'] );
    					$width = $size[ 0 ];
    					$height = $size[ 1 ];
    					$dest_h = 500;
    					$dest_w = 500;
    					$miniature = ImageCreateTrueColor( $dest_w, $dest_h);
    					$image = ImageCreateFromJpeg('photoProfil/'.$h['x-file-name'] );
    					ImageCopyResampled( $miniature, $image, 0, 0, 0, 0, $dest_w, $dest_h, $width, $height );
    					ImageJpeg( $miniature, 'photoProfil/'.$h['x-file-name'], 100 );
    $o->name="photoProfil/".$h['x-file-name'];

}
echo json_encode($o);
?>