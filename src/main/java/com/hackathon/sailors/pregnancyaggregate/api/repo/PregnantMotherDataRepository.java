package com.hackathon.sailors.pregnancyaggregate.api.repo;

import com.hackathon.sailors.pregnancyaggregate.models.PregnantMotherData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PregnantMotherDataRepository extends JpaRepository<PregnantMotherData, Integer> {
}
