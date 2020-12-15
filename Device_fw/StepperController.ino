void uStepConverter(int target){
    switch(target){
        case 0:{
            digitalWrite(focuser_m1, LOW);
            digitalWrite(focuser_m2, LOW);
            digitalWrite(focuser_m3, LOW);
        }
        case 1:{
            digitalWrite(focuser_m1, HIGH);
            digitalWrite(focuser_m2, LOW);
            digitalWrite(focuser_m3, LOW);
        }
        case 2:{
            digitalWrite(focuser_m1, LOW);
            digitalWrite(focuser_m2, HIGH);
            digitalWrite(focuser_m3, LOW);
        }
        case 3:{
            digitalWrite(focuser_m1, HIGH);
            digitalWrite(focuser_m2, HIGH);
            digitalWrite(focuser_m3, LOW);
        }
        case 4:{
            digitalWrite(focuser_m1, LOW);
            digitalWrite(focuser_m2, LOW);
            digitalWrite(focuser_m3, HIGH);
        }
        case 5:{
            digitalWrite(focuser_m1, HIGH);
            digitalWrite(focuser_m2, LOW);
            digitalWrite(focuser_m3, HIGH);
        }
        case 6:{
            digitalWrite(focuser_m1, LOW);
            digitalWrite(focuser_m2, HIGH);
            digitalWrite(focuser_m3, HIGH);
        }
        case 7:{
            digitalWrite(focuser_m1, HIGH);
            digitalWrite(focuser_m2, HIGH);
            digitalWrite(focuser_m3, HIGH);
        }
        
    }
}
