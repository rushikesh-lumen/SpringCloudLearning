//package gateway;
//
//import org.junit.jupiter.api.Test; // MIGRATED: JUnit 4 -> JUnit 5
//// MIGRATED: @RunWith removed - JUnit 5 uses @ExtendWith automatically with @SpringBootTest
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
//// MIGRATED: SpringRunner replaced by SpringExtension in JUnit 5 (auto-configured by @SpringBootTest)
//import org.springframework.test.web.reactive.server.WebTestClient;
//
//import static com.github.tomakehurst.wiremock.client.WireMock.*;
//import static org.assertj.core.api.Assertions.*;
//
///**
// * @author Ryan Baxter
// */
//// tag::code[]
//// MIGRATED: @RunWith(SpringRunner.class) removed - JUnit 5 uses SpringExtension automatically
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
//		properties = {"httpbin=http://localhost:${wiremock.server.port}"})
//@AutoConfigureWireMock(port = 0)
//public class ApplicationTest {
//
//	@Autowired
//	private WebTestClient webClient;
//
//	@Test
//	public void contextLoads() throws Exception {
//		//Stubs
//		stubFor(get(urlEqualTo("/get"))
//				.willReturn(aResponse()
//					.withBody("{\"headers\":{\"Hello\":\"World\"}}")
//					.withHeader("Content-Type", "application/json")));
//		stubFor(get(urlEqualTo("/delay/3"))
//			.willReturn(aResponse()
//				.withBody("no fallback")
//				.withFixedDelay(3000)));
//
//		webClient
//			.get().uri("/get")
//			.exchange()
//			.expectStatus().isOk()
//			.expectBody()
//			.jsonPath("$.headers.Hello").isEqualTo("World");
//
//		webClient
//			.get().uri("/delay/3")
//			.header("Host", "www.hystrix.com")
//			.exchange()
//			.expectStatus().isOk()
//			.expectBody()
//			.consumeWith(
//				response -> assertThat(response.getResponseBody()).isEqualTo("fallback".getBytes()));
//	}
//}
//// end::code[]