
public class BookingBuilder {
    private Booking bookingResult;

    public BookingBuilder () {
        this.reset();
    }

    public BookingBuilder reset() {
        this.bookingResult = new Booking(-1, 0,
        0, null, null, null);

        return this;
    }

    public BookingBuilder setBookingId(int bookingId) {
        this.bookingResult = new Booking(bookingId,
                this.bookingResult.getDownPayment(),
                this.bookingResult.getNumberOfParticipants(),
                this.bookingResult.getTimeSlot(),
                this.bookingResult.getRoom(),
                this.bookingResult.getCustomer());

        return this;
    }

    public BookingBuilder setDownPayment(float downPayment) {
        this.bookingResult = new Booking(this.bookingResult.getBookingId(),
                downPayment,
                this.bookingResult.getNumberOfParticipants(),
                this.bookingResult.getTimeSlot(),
                this.bookingResult.getRoom(),
                this.bookingResult.getCustomer());

        return this;
    }

    public BookingBuilder setNumberOfParticipants(int numberOfParticipants) {
        this.bookingResult = new Booking(this.bookingResult.getBookingId(),
                this.bookingResult.getDownPayment(),
                numberOfParticipants,
                this.bookingResult.getTimeSlot(),
                this.bookingResult.getRoom(),
                this.bookingResult.getCustomer());

        return this;
    }

    public BookingBuilder setTimeSlot(String timeSlot) {
        this.bookingResult = new Booking(this.bookingResult.getBookingId(),
                this.bookingResult.getDownPayment(),
                this.bookingResult.getNumberOfParticipants(),
                timeSlot,
                this.bookingResult.getRoom(),
                this.bookingResult.getCustomer());

        return this;
    }

    public BookingBuilder setRoom (Room room){
        this.bookingResult = new Booking(this.bookingResult.getBookingId(),
                this.bookingResult.getDownPayment(),
                this.bookingResult.getNumberOfParticipants(),
                this.bookingResult.getTimeSlot(),
                room,
                this.bookingResult.getCustomer());

        return this;
    }

    public BookingBuilder setCustomer(Customer customer) {
        this.bookingResult = new Booking(this.bookingResult.getBookingId(),
                this.bookingResult.getDownPayment(),
                this.bookingResult.getNumberOfParticipants(),
                this.bookingResult.getTimeSlot(),
                this.bookingResult.getRoom(),
                customer);

        return this;
    }

    public Booking build() {
        Booking result = this.bookingResult;
        this.reset();
        return result;
    }
}
