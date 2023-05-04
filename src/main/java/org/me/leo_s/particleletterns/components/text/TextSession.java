package org.me.leo_s.particleletterns.components.text;

import org.bukkit.Color;
import org.json.simple.JSONObject;
import org.me.leo_s.particleletterns.ParticleLetters;
import org.me.leo_s.particleletterns.components.builders.maths.MathsUtils;
import org.me.leo_s.particleletterns.components.exceptions.TextFormattedInvalid;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

@SuppressWarnings({"unused", "ResultOfMethodCallIgnored"})
public class TextSession {
    private String text;
    private int timePerLetter;
    private Color color;
    private double lengthLines;
    private double spaceLetters;
    private TextParticle preview;

    public TextSession(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getTimePerLetter() {
        return timePerLetter;
    }

    public void setTimePerLetter(int timePerLetter) {
        this.timePerLetter = timePerLetter;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getLengthLines() {
        return lengthLines;
    }

    public void setLengthLines(double lengthLines) {
        this.lengthLines = lengthLines;
    }

    public double getSpaceLetters() {
        return spaceLetters;
    }

    public void setSpaceLetters(double spaceLetters) {
        this.spaceLetters = spaceLetters;
    }
    public TextParticle getPreview() {
        return preview;
    }
    public void setPreview(TextParticle preview) {
        this.preview = preview;
    }

    public void ready() throws TextFormattedInvalid {
        if(this.text == null) {
            throw new TextFormattedInvalid("§8[§cParticleLetters§8] §7The text must be §cnot null§7.");
        }
        if(this.timePerLetter <= 0) {
            throw new TextFormattedInvalid("§8[§cParticleLetters§8] §7The time per letter must be §cgreater than 0§7.");
        }
        if(!this.text.contains("&") && this.color == null) {
            throw new TextFormattedInvalid("§8[§cParticleLetters§8] §7The color must be §cnot null§7.");
        }
        if(this.lengthLines <= 0) {
            throw new TextFormattedInvalid("§8[§cParticleLetters§8] §7The length lines must be §cgreater than 0§7.");
        }

        String nameClear = MathsUtils.clearVanillaText(this.text);
        File file = new File("plugins/ParticleLetters/texts/" + nameClear + ".json");
        TextParticle textParticle;

        if (!text.contains("&")) textParticle = new TextParticle(this);
        else textParticle = new TextParticle(text, timePerLetter, lengthLines, spaceLetters);

        try {
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();

            Writer fileWriter = new FileWriter(file);
            JSONObject jsonObject = textParticle.toJson();
            jsonObject.writeJSONString(fileWriter);
            fileWriter.flush();
            fileWriter.close();
            ParticleLetters.getInstance().addTextParticle(nameClear, textParticle);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean allValuesCompleted(boolean preview) {
        if(preview) return this.text != null && this.timePerLetter > 0 && this.lengthLines > 0;
        else return this.text != null && this.timePerLetter > 0 && this.color != null && this.lengthLines > 0;
    }

    public void stopPreview() {
        if(this.preview != null) {
            this.preview.cancelTask();
        }
    }
}
