package ru.trainee.adminpanel;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import ru.trainee.adminpanel.data.model.Banner;
import ru.trainee.adminpanel.data.repository.BannerRepository;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
@Sql("/script-before-running-banner.sql")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class DatabaseBannerTableTest {

    @Autowired
    private BannerRepository bannerRepository;

    @Test
    public void FindAllOperationTest() throws Exception {
        List<Banner> banners = bannerRepository.findAll();

        for (Banner banner : banners)
            System.out.println(banner);

        int size = bannerRepository.findAll().size();

        System.out.println(size);

        assertThat(size, is(6));
    }

    @Test
    public void AddOperationTest() throws Exception {
        int initialSize = bannerRepository.findAll().size();

        Banner banner = new Banner(0L, "https://avatars.mds.yandex.net/get-pdb/33827/9dbf1104-bc82-496e-a39a-b49114678b52/s1200?webp=false", 600, 338, "https://www.hyundai.ru", "Russian");
        bannerRepository.save(banner);

        int currentSize = bannerRepository.findAll().size();

        assertThat(currentSize, is(initialSize + 1));
    }

    @Test
    public void EditOperationTest() throws Exception {
        final String newTargetUrl = "https://www.hyundai.com/worldwide/en/";
        final String newLanguageId = "English";

        // Change targetUrl and langId
        Banner banner = new Banner(0L, "https://avatars.mds.yandex.net/get-pdb/33827/9dbf1104-bc82-496e-a39a-b49114678b52/s1200?webp=false", 600, 338, newTargetUrl, newLanguageId);
        banner = bannerRepository.save(banner);

        Optional<Banner> resultBanner = bannerRepository.findById(banner.getId());

        assertThat(resultBanner.get().getTargetUrl(), equalTo(newTargetUrl));
        assertThat(resultBanner.get().getLangId(), equalTo(newLanguageId));
    }

    @Test
    public void DeleteOperationTest() throws Exception {
        bannerRepository.deleteById(6L);

        Optional<Banner> resultBanner = bannerRepository.findById(6L);

        assertThat(resultBanner.isPresent(), is(false));
    }
}

