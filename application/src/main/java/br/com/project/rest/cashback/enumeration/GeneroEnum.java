package br.com.project.rest.cashback.enumeration;

public enum GeneroEnum {

    POP(0), MPB(1), CLASSIC(2), ROCK(3);

    private int value;

    GeneroEnum(final int value){
        this.value = value;
    }

    public static String toGender(String descricao) {

        switch(descricao) {
            case "POP":
                return "pop";
            case "MPB":
                return "mpb";
            case "CLASSIC":
                return "classic";
            case "ROCK":
                return "rock";
        }

        return "";
    }

}
