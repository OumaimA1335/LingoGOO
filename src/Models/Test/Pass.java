/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Test;

/**
 *
 * @author marwa
 */

public final class Pass extends TestResult {
    private final String congratulationsMessage;

    public Pass(String message, String congratulationsMessage) {
        super(message);  
        this.congratulationsMessage = congratulationsMessage;
    }

    public String getCongratulationsMessage() {
        return congratulationsMessage;
    }
}
