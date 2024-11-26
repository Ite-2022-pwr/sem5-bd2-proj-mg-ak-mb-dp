package pl.pwr.ite.bd2.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPostCode is a Querydsl query type for PostCode
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPostCode extends EntityPathBase<PostCode> {

    private static final long serialVersionUID = 2107314508L;

    public static final QPostCode postCode1 = new QPostCode("postCode1");

    public final QEntityBase _super = new QEntityBase(this);

    public final SetPath<Address, QAddress> addresses = this.<Address, QAddress>createSet("addresses", Address.class, QAddress.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> created = _super.created;

    //inherited
    public final ComparablePath<java.util.UUID> id = _super.id;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modified = _super.modified;

    public final StringPath postCode = createString("postCode");

    public QPostCode(String variable) {
        super(PostCode.class, forVariable(variable));
    }

    public QPostCode(Path<? extends PostCode> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPostCode(PathMetadata metadata) {
        super(PostCode.class, metadata);
    }

}

