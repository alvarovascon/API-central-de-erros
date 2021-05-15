package com.central.main.suite;

import com.central.main.Model.EventPage;
import com.central.main.entity.Event;
import com.central.main.service.EventService;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Sql({"/event_service_test.sql"})
@ActiveProfiles("test")
public class EventServiceTest {

    @Autowired
    private EventService eventService;

    private EventPage getPageable() {
        EventPage eventPage = new EventPage();
        eventPage.setPageNumber(0);
        eventPage.setPageSize(10);
        eventPage.setDirection(Sort.Direction.ASC);
        eventPage.setSortBy("id");
        return eventPage;
    }

    private Event getEvent() {
        Event event = new Event();
        event.setLevel("level");
        event.setDescription("description");
        event.setLog("log");
        event.setOrigin("origin");
        event.setEventDate(LocalDateTime.now());
        return event;
    }

    private void assertEvent(Event result) {
        Assert.assertThat(result.getId(), Matchers.notNullValue());
        Assert.assertThat(result.getLevel(), Matchers.equalTo("level"));
        Assert.assertThat(result.getDescription(), Matchers.equalTo("description"));
        Assert.assertThat(result.getLog(), Matchers.equalTo("log"));
        Assert.assertThat(result.getOrigin(), Matchers.equalTo("origin"));
        Assert.assertThat(result.getEventDate(), Matchers.notNullValue());
    }

    @Test
    @Transactional
    public void whenSave() {
        Event event = this.getEvent();
        Event result = this.eventService.save(event);
        this.assertEvent(result);
    }

    @Test
    @Transactional
    public void whenFindById() {
        Optional<Event> result = this.eventService.findById(AbstractTest.EventIds.ONE);
        Assert.assertThat(result.isPresent(), Matchers.equalTo(true));
        this.assertEvent(result.get());
    }

    @Test
    @Transactional
    public void whenFindAll() {
        Page<Event> result = this.eventService.findAll(getPageable());
        Assert.assertThat(result.getContent(), Matchers.hasSize(3));
    }

    @Test
    @Transactional
    public void whenFindByLevel() {
        Page<Event> result = this.eventService.findByLevel(AbstractTest.EventLevels.WARNING, getPageable());
        Assert.assertThat(result.getContent(), Matchers.hasSize(2));
    }

}
