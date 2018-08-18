import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.FileCopyUtils;
import com.sportmonks.aggregate.core.data.entity.League;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
public class JsonTest {

    @Value("classpath:getLeagues.json")
    private Resource jsonFile;
    @Value("classpath:getLeaguesFull.json")
    private Resource jsonFileFull;

    //    @Test
    public void testReadFromJson() throws IOException {
        System.out.println(jsonFile.getFilename());
        String copyToString = FileCopyUtils.copyToString(new FileReader(jsonFile.getFile()));
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
        List<League> result = mapper.readerFor(new TypeReference<List<League>>() {
        }).withRootName("data").readValue(copyToString);
        Assert.assertEquals(2, result.size());
        Assert.assertNotNull(result.get(1));
    }

    @Test
    public void testReadFromJsonFull() throws IOException {
        System.out.println(jsonFileFull.getFilename());
        String copyToString = FileCopyUtils.copyToString(new FileReader(jsonFileFull.getFile()));
        ObjectMapper mapper = new ObjectMapper();
        JsonNode data = mapper.readTree(copyToString).path("data");
        List<League> result = Arrays.asList(mapper.treeToValue(data, League[].class));
        System.out.println(result);
        Assert.assertEquals(2, result.size());
        Assert.assertNotNull(result.get(1));
    }

    //    @Test
    public void testLeagueDeser() throws IOException {
        String jsonText = "{\n" +
                "\t\"id\": 271,\n" +
                "\t\"legacy_id\": 43,\n" +
                "\t\"country_id\": 320,\n" +
                "\t\"name\": \"Superliga\",\n" +
                "\t\"is_cup\": false,\n" +
                "\t\"current_season_id\": 12919,\n" +
                "\t\"current_round_id\": 147057,\n" +
                "\t\"current_stage_id\": 7088928,\n" +
                "\t\"live_standings\": true,\n" +
                "\t\"coverage\": {\n" +
                "\t\t\"topscorer_goals\": true,\n" +
                "\t\t\"topscorer_assists\": true,\n" +
                "\t\t\"topscorer_cards\": true\n" +
                "\t}\n" +
                "}";
        ObjectMapper mapper = new ObjectMapper();
        League league = mapper.readValue(jsonText, League.class);
        Assert.assertNotNull(league);
    }
}
