package com.hackathon.sailors.pregnancyaggregate.api.repo;

import com.hackathon.sailors.pregnancyaggregate.models.DataEntryForm;
import com.hackathon.sailors.pregnancyaggregate.models.PregnantMotherData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormsRepository extends JpaRepository<DataEntryForm, String> {
}
