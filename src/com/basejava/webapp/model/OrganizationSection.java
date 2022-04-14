package com.basejava.webapp.model;


import java.util.List;
import java.util.Objects;

public class OrganizationSection extends Section{
    private final List<OrganizationSection> organization;


    public OrganizationSection(List<OrganizationSection> organization) {
        Objects.requireNonNull(organization,"organization must not be null");
        this.organization = organization;
    }

    public List<OrganizationSection> getOrganization() {
        return organization;
    }

    @Override
    public String toString() {
        return "OrganizationSection{" +
                "organization=" + organization +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrganizationSection that = (OrganizationSection) o;

        return organization.equals(that.organization);
    }

    @Override
    public int hashCode() {
        return organization.hashCode();
    }
}
