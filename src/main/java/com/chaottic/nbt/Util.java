package com.chaottic.nbt;

import java.io.DataInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.GZIPInputStream;

public final class Util {

    private Util() {}

    public static CompoundTag readCompoundTag(Path path) throws IOException {
        try (var dataInputStream = new DataInputStream(new GZIPInputStream(Files.newInputStream(path)))) {
            dataInputStream.readByte();
            dataInputStream.readUTF();
            return CompoundTag.createCompoundTag(dataInputStream);
        }
    }
}
