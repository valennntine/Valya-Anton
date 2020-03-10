/*package com.company.DAO;

import com.company.model.BookingC;

import java.io.*;

public class DAO_BookingC {
    public BookingC readBookingC(long id)
    {

        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Java tasks\\Epam_University\\BD\\BookingC\\In\\"+id+".txt")))
        {
            long Id = Long.parseLong(reader.readLine());
            String name = reader.readLine();
            String address = reader.readLine();
            String phone = reader.readLine();
            double avgbill = Double.parseDouble(reader.readLine());
            String dateAndTime = reader.readLine();
            int numberOfPeople = Integer.parseInt(reader.readLine());
            long numberOfReservation = Long.parseLong(reader.readLine());
            String codeWord = reader.readLine();

            return new BookingC(Id,name,address,phone,avgbill,dateAndTime,numberOfPeople,numberOfReservation,codeWord);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void writeBookingC(BookingC bookingC, long id) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Java tasks\\Epam_University\\BD\\BookingC\\Out\\"+id+".txt"))) {
            writer.write(bookingC.toString());
        }
    }
}
*/