void BlueHandler(){
    // focuser command
    if(command == "fi"){         // 포커서를 넣어주는 커맨드
        focuser.moveTo(100000000);
    }
    else if(command == "fo"){    // 포커서를 빼주는 커맨드
        focuser.moveTo(-100000000);
    }
    else if(command == "f0"){   // 현재 위치를 0으로 초기화하는 커맨드
        focuser.setCurrentPosition(0);
    }
    else if(command.startsWith("fu")){    // ustep을 제어 커맨드
        uStepConverter(command[2]);
    }


    // filterwheel command
    if(command == "wn"){         // 다음 필터로 넘어가는 커맨드
        //filterWheel.move(40000);
        bluetooth.write("we#");
    }
    else if(command == "wp"){    // 이전 필터로 돌아가는 커맨드
        //filterWheel.move(40000);
        bluetooth.write("we#");
    }
    else if(command == "won"){
        digitalWrite(filterWheel_en, HIGH);
    }
    else if(command == "woff"){
        digitalWrite(filterWheel_en, LOW);
    }

    
    // exception handler
    else{
        
    }
}
