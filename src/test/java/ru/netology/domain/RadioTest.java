package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {
    Radio radio = new Radio();

    @Test
    public void createRadio() {
        String expected = "Радио";
        assertNull(radio.getName());
        radio.setName(expected);
        assertEquals(expected, radio.getName());
    }

    @Test
    public void validateChangFields() {
        assertEquals(0,radio.getCurrentRadioStation());
        radio.setCurrentRadioStation(5);
        assertEquals(5, radio.getCurrentRadioStation());
    }

    @Test
    public void changeAfterLastRadioStation() {
        radio.setCurrentRadioStation(9);
        radio.pressNextStation();
        assertEquals(0, radio.getCurrentRadioStation());
    }

    @Test
    public void changeUnderInitialRadioStation() {
        radio.setCurrentRadioStation(0);
        radio.pressPrevStation();
        assertEquals(9, radio.getCurrentRadioStation());
    }

    @Test
    public void nextRadioStation() {
        radio.setCurrentRadioStation(7);
        radio.pressNextStation();
        assertEquals(8, radio.getCurrentRadioStation());
    }

    @Test
    public void prevRadioStation() {
        radio.setCurrentRadioStation(4);
        radio.pressPrevStation();
        assertEquals(3, radio.getCurrentRadioStation());
    }

    @Test
    public void afterInitialRadioStation() {
        radio.setCurrentRadioStation(12);
        radio.getMaxRadioStation();
        assertEquals(0, radio.getCurrentRadioStation());
    }

    @Test
    public void underInitialRadioStation() {
        radio.setCurrentRadioStation(-2);
        radio.getMinRadioStation();
        assertEquals(0, radio.getCurrentRadioStation());
    }

    // volume
    @Test
    public void volumeOverMax() {
        radio.setCurrentVolume(13);
        radio.getMaxVolume();
        assertEquals(10, radio.getMaxVolume());
    }

    @Test
    public void volumeDownUnderMin() {
        radio.setCurrentVolume(-11);
        radio.getMinVolume();
        assertEquals(0, radio.getMinVolume());
    }

    @Test
    public void plusVolume() {
        radio.setCurrentVolume(2);
        radio.pressPlusVolume();
        assertEquals(3, radio.getCurrentVolume());
    }

    @Test
    public void minusVolume() {
        radio.setCurrentVolume(5);
        radio.pressMinusVolume();
        assertEquals(4, radio.getCurrentVolume());
    }

}