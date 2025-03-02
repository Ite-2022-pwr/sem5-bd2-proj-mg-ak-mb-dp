package pl.pwr.ite.bd2.model.filter;

import lombok.Data;

@Data
public abstract class Filter {

    private int pageOffset = -1;

    private int pageLimit = -1;

    private String sortSchema;

    private String sortDirection;
}
