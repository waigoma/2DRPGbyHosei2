//package nagai;
//
//if((x < 930) && ((x+50) > 900) && (y < 315) && ((y+30) > 300)){
//    if(x >= 915){
//        x = 930;
//    }else if((x+50) <= 915){
//        x = 850;
//    }else if(y >= 307){
//        y = 315;
//    }else if((y+30) <= 307){
//        y = 270;
//    }
//}
//if((x < 930) && ((x+50) > 900) && (y < 315) && ((y+30) > 300)){
//        if(x >= 915 && (y+30) < 301 || y >314) {
//        x = 930;
//        }else if((x+50) <= 915 &&  (y+30) < 301 || y >314){
//        x = 850;
//        }else if(y >= 307){
//        y = 315;
//        }else if((y+30) <= 307){
//        y = 270;
//        }
//if((Playerx < (x + width)) && ((Playerx + PlayerWidth) > x) && (Playery < (y + height)) && ((Playery + PlayerHeight) > y)){
//        if(Playerx > x + (width/2) && Playery > (y + (height - 1)) || ((Playery + PlayerHeight) < y + 1)){
//        Playerx = x + width;
//        }else if((Playerx + PlayerWidth) < x + (width/2) &&Playery > (y + (height - 1)) || ((Playery + PlayerHeight) < y - 1) ){
//        Playerx = x - PlayerWidth;
//        }else if(Playery > y + (height/2)){
//        Playery = y + height;
//        }else if((Playery + PlayerHeight) < y + (height/2)){
//        Playery = y - PlayerHeight;