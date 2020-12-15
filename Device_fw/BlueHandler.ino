void BlueHandler(){
    // focuser command
    if(command == "i"){         // 포커서를 넣어주는 커맨드
        focuser.moveTo(100000000);
    }
    else if(command == "o"){    // 포커서를 빼주는 커맨드
        focuser.moveTo(-100000000);
    }
    else if(command == "01"){   // 현재 위치를 0으로 초기화하는 커맨드
        focuser.setCurrentPosition(0);
    }
    else if(command == "u"){    // ustep을 제어 커맨드
        uStepConverter(atoi(command[1]));
    }


    // filterwheel command
    if(command == "n"){         // 다음 필터로 넘어가는 커맨드
        //filterWheel.moveTo();
    }
    else if(command == "p"){    // 이전 필터로 돌아가는 커맨드
        //filterWheel.moveTo();
    }

    
    // exception handler
    else{
        
    }
}
