void CorRenew(){
    //블루투스로 현재 좌표+#을 전송
    char *temp_cor;
    sprintf(temp_cor, "c%d#", focuser.currentPosition());
    bluetooth.write(temp_cor);
}
