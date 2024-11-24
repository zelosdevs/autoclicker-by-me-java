package com.zelodev.thirdclicker;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.Random;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class AutoClicker implements NativeKeyListener {

    private static boolean toggled = false; // Kattintás engedélyezése
    private static int minCPS = 8;
    private static int maxCPS = 12;
    private static Robot robot;

    public static void main(String[] args) {
        try {
            // Robot inicializálás
            robot = new Robot();

            // Hook regisztrálása
            GlobalScreen.registerNativeHook();
            GlobalScreen.addNativeKeyListener(new AutoClicker());

            System.out.println("AutoClicker elindult! Nyomd meg az 'F6'-ot a bekapcsoláshoz/kikapcsoláshoz.");

            Random random = new Random();
            long lastClickTime = 0;
            int delay = 0;

            while (true) {
                if (toggled) {
                    long currentTime = System.currentTimeMillis();

                    // Ha lejárt az idő a következő kattintásig
                    if (currentTime - lastClickTime >= delay) {
                        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

                        lastClickTime = currentTime;

                        // Véletlenszerű késleltetés kiszámítása (CPS alapján)
                        delay = 1000 / (random.nextInt(maxCPS - minCPS + 1) + minCPS);
                    }
                }

                Thread.sleep(1); // Kis várakozás a CPU terhelés csökkentése érdekében
            }
        } catch (AWTException | NativeHookException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        // F6 gomb váltó (toggle) funkció
        if (e.getKeyCode() == NativeKeyEvent.VC_F6) {
            toggled = !toggled;
            System.out.println(toggled ? "AutoClicker BEkapcsolva!" : "AutoClicker KIkapcsolva!");
        }
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent e) {
        // Nem szükséges implementálni
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent e) {
        // Nem szükséges implementálni
    }
}

