/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package masterlanguagefx;

/**
 *
 * @author marwa
 */
public class Langue {
    private int id;
    private String NativeLanguage;
    private String languageLearn;

    public Langue(int id, String NativeLanguage, String languageLearn) {
        this.id = id;
        this.NativeLanguage = NativeLanguage;
        this.languageLearn = languageLearn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNativeLanguage() {
        return NativeLanguage;
    }

    public void setNativeLanguage(String NativeLanguage) {
        this.NativeLanguage = NativeLanguage;
    }

    public String getLanguageLearn() {
        return languageLearn;
    }

    public void setLanguageLearn(String languageLearn) {
        this.languageLearn = languageLearn;
    }  
}
