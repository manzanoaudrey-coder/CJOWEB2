package br.edu.ifspcjo.ads.web2.SdD.domain.model;

public enum DenunciationType {
	
    MAUSTRATOSAOSANIMAIS  ("Maus Tratos aos Animais"),
    ROUBO ("Roubo"),
    ASSASSINATO ("Assassinato"),
    ABUSOSEXUAL ("Abuso Sexual");

    private String type;

    DenunciationType(String type) {
        this.type = type;
    }

    public String getType(){
        return this.type;
    }

}
