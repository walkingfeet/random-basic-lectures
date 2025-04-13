package com.walkingfeet.example.avro

import org.apache.avro.file.DataFileStream
import org.apache.avro.file.DataFileWriter
import org.apache.avro.io.DatumReader
import org.apache.avro.io.DatumWriter
import org.apache.avro.specific.SpecificDatumReader
import org.apache.avro.specific.SpecificDatumWriter
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import kotlin.test.assertEquals
import kotlin.test.assertTrue


class UserSampleSerializeTest {

    @Test
    fun `should encode and decode object`() {
        // #region EncodingAndDecoding
        // Encoding
        val user = UserSampleAvro("Dmitry", 31, "dmitry@example.com")

        val outputStream = ByteArrayOutputStream()
        val userWriter: DatumWriter<UserSampleAvro> = SpecificDatumWriter(UserSampleAvro::class.java)

        val dataFileWriter: DataFileWriter<UserSampleAvro> = DataFileWriter(userWriter)

        dataFileWriter.create(user.schema, outputStream)
        dataFileWriter.append(user)
        dataFileWriter.close()

        //Decoding
        val inputStream = ByteArrayInputStream(outputStream.toByteArray())
        val userReader: DatumReader<UserSampleAvro> = SpecificDatumReader(UserSampleAvro::class.java)
        val dataFileReader: DataFileStream<UserSampleAvro> = DataFileStream(inputStream, userReader)

        val deserializedUser = mutableListOf<UserSampleAvro>()
        while (dataFileReader.hasNext()) {
            val readUser: UserSampleAvro = dataFileReader.next()
            deserializedUser.add(readUser)
        }
        dataFileReader.close()
        // #endregion
        assertTrue(deserializedUser.size == 1, "Serialized only one user")
        assertEquals(deserializedUser[0], user)
    }
}