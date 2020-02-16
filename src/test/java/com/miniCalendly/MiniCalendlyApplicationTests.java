package com.miniCalendly;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.miniCalendly.model.Booking;
import com.miniCalendly.model.Opening;
import com.miniCalendly.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class MiniCalendlyApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Test
	public void shouldFetchAllUsers() throws Exception {
		this.mockMvc.perform(get("/users")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void shouldFetchFirstUser() throws Exception {
		this.mockMvc.perform(get("/users/1")).andDo(print())
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.username").value("bilbo"));
	}

	@Test
	public void shouldNotFetch100thUser() throws Exception {
		this.mockMvc.perform(get("/users/100")).andDo(print())
				.andExpect(status().isNotFound());
	}

	@Test
	public void shouldCreateUser() throws Exception {
		this.mockMvc.perform(
				post("/users")
				.content(asJsonString(new User("max", "Max Voldemort", "01:00")))
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().is2xxSuccessful())
				.andExpect(MockMvcResultMatchers.jsonPath("$.username").value("max"));
	}

	// Openings Tests
	@Test
	public void shouldFetchAllOpenings() throws Exception {
		this.mockMvc.perform(get("/openings")).andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	public void shouldFetchFirstOpening() throws Exception {
		this.mockMvc.perform(get("/openings/4")).andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	public void shouldFetchOpeningsByMentor() throws Exception {
		this.mockMvc.perform(get("/mentor/1/openings")).andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	public void shouldNotFetch100thOpening() throws Exception {
		this.mockMvc.perform(get("/openings/100")).andDo(print())
				.andExpect(status().isNotFound());
	}

	@Test
	public void shouldCreateBooking() throws Exception {
		String dateTime = "2020-02-15T16:20:13.274+0000";
		this.mockMvc.perform(
				post("/openings")
						.content(asJsonString(new Opening((long) 1, dateTime)))
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().is2xxSuccessful())
				.andExpect(MockMvcResultMatchers.jsonPath("$.date_time").value(dateTime));
	}

	// Bookings Tests
	@Test
	public void shouldFetchAllBookings() throws Exception {
		this.mockMvc.perform(get("/bookings")).andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	public void shouldFetchFirstBooking() throws Exception {
		this.mockMvc.perform(get("/bookings/9")).andDo(print())
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").value(9));
	}

	@Test
	public void shouldFetchBookingsByUser() throws Exception {
		this.mockMvc.perform(get("/user/2/bookings")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void shouldNotFetch100Booking() throws Exception {
		this.mockMvc.perform(get("/bookings/90")).andDo(print()).andExpect(status().is4xxClientError());
	}

	@Test
	public void shouldBookOpenSlot() throws Exception {
		String dateTime = "2020-02-17T16:20:13.274+0000";
		String message = "I want to discuss UX/UI";

		this.mockMvc.perform(
				post("/bookings")
						.content(asJsonString(new Booking((long) 1, (long) 2, message, dateTime)))
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().is2xxSuccessful())
				.andExpect(MockMvcResultMatchers.jsonPath("$.date_time").value(dateTime))
				.andExpect(MockMvcResultMatchers.jsonPath("$.message").value(message));
	}

	@Test
	public void shouldNotBookSlotThatIsNotOpen() throws Exception {
		String dateTime = "2021-02-17T16:20:13.274+0000";
		String message = "I want to discuss UX/UI";

		this.mockMvc.perform(
				post("/bookings")
						.content(asJsonString(new Booking((long) 1, (long) 2, message, dateTime)))
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().is4xxClientError());
	}
}
