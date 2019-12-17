package br.com.project.rest.cashback.enumeration;

import java.util.Calendar;
import java.util.Date;

public enum DiaEnum {

    DOM(0), SEG(1), TER(2), QUA(3), QUI(4), SEX(5), SAB(6), NONE(7);

    private int value;

    DiaEnum(final int value){
        this.value = value;
    }

    public static DiaEnum toEnum(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        switch(calendar.get(Calendar.DAY_OF_WEEK)) {
            case 1:
                return DiaEnum.DOM;
            case 2:
                return DiaEnum.SEG;
            case 3:
                return DiaEnum.TER;
            case 4:
                return DiaEnum.QUA;
            case 5:
                return DiaEnum.QUI;
            case 6:
                return DiaEnum.SEX;
            case 7:
                return DiaEnum.SAB;
        }

        return DiaEnum.NONE;
    }

}
