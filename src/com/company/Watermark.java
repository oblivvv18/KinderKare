package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Watermark extends JTextField {
    private String watermarkText;

    public Watermark(final String watermarkText) {
        this.watermarkText = watermarkText;
        setForeground(Color.GRAY);

        // focus listener ay for handling the behavior
        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {   //focus gained=when clicked
                if (getText().equals(watermarkText)) {
                    setText("");
                    setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {  //focus lost = clicked sa labas ng text field
                if (getText().isEmpty()) {
                    setText(watermarkText);
                    setForeground(Color.GRAY);
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (getText().isEmpty()) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(getForeground());
            g2d.setFont(getFont().deriveFont(Font.ITALIC));
            int x = getInsets().left + 5; // customization kung paano papaint watermark if wala lagay
            int y = (getHeight() - g2d.getFontMetrics().getHeight()) / 2 + g2d.getFontMetrics().getAscent();
            g2d.drawString(watermarkText, x, y);
        }
    }
}