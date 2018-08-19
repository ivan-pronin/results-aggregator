import org.junit.Test;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class UriTest {

    @Test
    public void constructUri() {
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme("http").host("www.baeldung.com").path("/junit-5").build();
        assertEquals("http://www.baeldung.com/junit-5", uriComponents.toUriString());
    }

    @Test
    public void constructUriFromTemplate() {
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme("http").host("www.baeldung.com").path("/{article-name}")
                .buildAndExpand("junit-5");
        assertEquals("http://www.baeldung.com/junit-5", uriComponents.toUriString());
    }

    @Test
    public void constructUriFromTemplateTwoPathParams() {
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme("http").host("www.baeldung.com").path("/{article-name}/{id}")
                .buildAndExpand("junit-5", "10");
        assertEquals("http://www.baeldung.com/junit-5/10", uriComponents.toUriString());
    }

    @Test
    public void constructUriWithQueryParameter() {
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme("http").host("www.google.com")
                .path("/").query("q={keyword}").buildAndExpand("baeldung");

        assertEquals("http://www.google.com/?q=baeldung", uriComponents.toUriString());
    }

    @Test
    public void constructUriWithTwoQueryParameter() {
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme("http").host("www.google.com")
                .path("/").query("q={value1}&x={value2}").buildAndExpand("baeldung", "second");
        assertEquals("http://www.google.com/?q=baeldung&x=second", uriComponents.toUriString());
    }

    @Test
    public void constructUriWithSeveralKeyQueryParameter() {
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme("http").host("www.google.com")
                .path("/").query("{key1}={value1}&{key2}={value2}").buildAndExpand("k1", "v1", "k2", "v2");
        assertEquals("http://www.google.com/?k1=v1&k2=v2", uriComponents.toUriString());
    }

    @Test
    public void constructUriWithMultivalueParams() {
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.add("k1", "v1");
        queryParams.add("k2", "v2");
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme("http").host("www.google.com")
                .path("/").queryParams(queryParams).build();
        assertEquals("http://www.google.com/?k1=v1&k2=v2", uriComponents.toUriString());
    }

    @Test
    public void expandWithRegexVar() {
        String template = "/myurl/{name:[a-z]{1,5}}/show";
        UriComponents uriComponents = UriComponentsBuilder.fromUriString(template)
                .build();
        uriComponents = uriComponents.expand(Collections.singletonMap("name", "test"));
        assertEquals("/myurl/test/show", uriComponents.getPath());
    }
}
