package com.example.lehuyduc.lab6.networking.services.get_data_service;

import com.example.lehuyduc.lab6.models.Note;

import java.util.Arrays;

/**
 * Created by Le Huy Duc on 18/12/2016.
 */

public class GetDataResponseBody {
    Note[] notes;

    @Override
    public String toString() {
        String res = "\n";
        for (Note note : notes) res += note.toString();
        return "GetDataResponseBody{" +
                "notes=" + res +
                '}';
    }
}
