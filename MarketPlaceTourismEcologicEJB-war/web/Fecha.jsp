<!DOCTYPE html>
        <html>
            <head>

<select name="dia">
        <?php
        for ($i=1; $i<=31; $i++) {
            if ($i == date('j'))
                echo '<option value="'.$i.'" selected>'.$i.'</option>';
            else
                echo '<option value="'.$i.'">'.$i.'</option>';
        }
        ?>
</select>

<select name="mes">
        <?php
        for ($i=1; $i<=12; $i++) {
            if ($i == date('m'))
                echo '<option value="'.$i.'" selected>'.$i.'</option>';
            else
                echo '<option value="'.$i.'">'.$i.'</option>';
        }
        ?>
</select>

<select name="ano">
        <?php
        for($i=date('o'); $i>=1910; $i--){
            if ($i == date('o'))
                echo '<option value="'.$i.'" selected>'.$i.'</option>';
            else
                echo '<option value="'.$i.'">'.$i.'</option>';
        }
        ?>
</select>

<?php
if (isset($_POST['enviar'])) {
    echo 'Fecha recibida: '.$_POST['dia'].'/'.$_POST['mes'].'/'.$_POST['ano'];
}
?>

       </body>

        </html>