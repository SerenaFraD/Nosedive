package utils;

public class Validator {
    public String emailMSG, nameMSG, pwdMSG, matchMSG;

    public Validator(String email, String nome, String pwd, String pwdConf) {
        if (email.length() < 3) {
            emailMSG = "\nE-Mail non valida: minimo 3 caratteri";
        } else if (email.length() > 40) {
            emailMSG = "\nE-Mail non valida: massimo 40 caratteri";
        } else if (!email.matches("^\\w+([.-]?\\w+)@\\w+([.-]?\\w+)(\\.\\w+)+$")) {
            emailMSG = "\nEmail non valida: scriverla nel formato ";
        } else {
            emailMSG = null;
        }

        if (nome.length() < 3) {
            nameMSG = "\nNome non valido: minimo 3 caratteri";
        } else if (nome.length() > 40) {
            nameMSG = "Nome non valido: massimo 40 caratteri";
        } else if (!nome.matches("^[ a-zA-Z\\u00C0-\\u00ff]+$")) {
            nameMSG = "\nNome non valido: usare solo lettere Maiuscole e minuscole";
        } else {
            nameMSG = null;
        }

        if (pwd.length() < 3) {
            pwdMSG = "\nPassword non valida: minimo 3 caratteri";
        } else if (pwd.length() > 16) {
            pwdMSG = "Password non valida: massimo 16 caratteri";
        } else if (!pwd.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")) {
            pwdMSG = "\nPassword non valida: Deve contenere Maiuscole, minuscole e un numero";
        } else {
            pwdMSG = null;
        }

        if (!pwd.equals(pwdConf)) {
            matchMSG = "\nAttenzione: le password devono coincidere";
        } else {
            matchMSG = null;
        }
    }

    public boolean wrongInput() {
        return (emailMSG != null || nameMSG != null || pwdMSG != null || matchMSG != null);
    }

}
