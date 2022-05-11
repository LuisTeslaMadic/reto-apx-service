package com.entelgy.app.utils;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.TimeZone;

import static org.junit.jupiter.api.Assertions.*;

class FunctionUtilsTest {

    @Test
    void fechaActual() {
      String fechaAct = FunctionUtils.fechaActual();
      assertNotNull(fechaAct);
    }
}