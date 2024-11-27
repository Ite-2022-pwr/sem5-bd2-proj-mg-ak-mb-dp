# Wstęp
Klasy potrzebne do pełnej obsługi encji
* Entity
* Filter i filter binder
* Repository
* Service
* DTO
* Mapper
* Facade
* Controller
## Entity
Każda klasa musi dziedziczyć po klasie `EntityBase` która zapewnia klucz podstawowy \
Po dodaniu nowej encji należy uruchomic polecenie `nvm clean install` w celu wygenerowania klas QueryDsl-a
### Wymagane adnotacje na klasie
* `@Entity`
* `@Table`
* `@Getter` i `@Setter`
* `@ToString(callSuper = true, onlyExplicitlyIncluded = true)`
### Kolumny
Każde pole która ma reprezentować kolumnę w bazie musi być oznaczone adnotacją `@Column`
### Relacje
Relacja jeden do wielu musi być reprezentowana przez pole typu encji do której się odwołujemy i oznaczone adnotacjami `@ManyToOne` oraz `@JoinColumn` \
Jeśli chcemy wyciągnąć wszystkie encje "po drugiej stronie" to w klasie encji musimy je oznaczyć w następujący sposób
```java
@OneToMany(mappedBy = "")
private Set<Encja> encje = new HashSet<>();
```
Gdzie parametr `mappedBy` musi być dokładną nazwą pola w drugiej klasie
## Filter i filter binder
Każda encja musi posiadać filtr zdefiniowany w następujący sposób (gdzie `Example` to przykładowa encja)

```java
@Data
public class ExampleFilter extends Filter {
}
```
Każdy filtr musi posiadać swój filter binder zdefuniowany w następujący sposób 
```java
@Component
public class ExampleFilterBinder extends FilterBinderBase<Example, ExampleFilter, QExample> {
}
```
## Repository
Każda encja musi podsiadać swoje repozytorium dzięki któremu możliwe jest wyciąganie rekordów z bazy \
Repoztorium musi być zdefiniowane w nastepujący sposób (`Example` to przykładowa encja)
```java
public interface ExampleRepository extends FilterableRepository<Example, ExampleFilter> {
}
```
## Service
Serwisy zapewniają podstawowe narzędzia do zapisywania, usuwania, filtrowania encji \
Serwis musi składać się z reprezentującego go interfejsu (`Example` to przykładowa encja)
```java
public interface ExampleService extends FilterableEntityService<Example, ExampleFilter> {
}
```
oraz jego implementacji (przy nadpisywaniu konstruktora należy zamienić argument z repozytorium z `FilterableRepository<>` na odpowiednie repozytorium)
```java
@Service
public class ExampleServiceImpl extends FilterableEntityServiceBase<Example, ExampleFilter> implements ExampleService {
}
```
## DTO
Do wymiany informacji między kontrolerami a serwisami służą klasy DTO \
Przykładowa klasa DTO

```java
@Data
public class ExampleDto {

    @Data
    @Accessors(chain = true)
    public static abstract class Properties implements MappingProperties {
        private boolean includeNestedExample;
    } 
    private String field;
    
    private NestedExampleDto nestedExample;
}
```
### Properties
Klasa properties jest wymagana i słuzy do kontrolowania mapowania zagnieżdżonych encji w DTO 

## Mapper
Mapery służą do mapowania encji na klasy DTO i są definiowane w następujący sposób
```java
@Component
@RequiredArgsConstructor
public class ExampleMapper extends MapperBase<Example, ExampleDto, ExampleDto.Properties> {

    private final NestedExampleMapper nestedExampleMapper;
    
    @Override
    public void transform(Example source, ExampleDto destination, ExampleDto.Properties properties) {
        destination.setField(source.getField());
        
        if(properties.isIncludeNestedExample()) {
            map(destination::setNestedExample, source.getNestedExample(), nestedExampleMapper, properties);
        }
    }
}
```
Ostatnie linijki służą do zmapowania zagnieżdżonej encji w zależności od flagi w klasie properties (flagi ustawiane są w kontrolerach)
## Facade
Fasady są połączeniem wszystkich poprzednich klas i służą do wymiany danych pomiędzy kontrolerami a warstwą serwisową \
Fasada definiowana jest w następujący sposób 
```java
@Component
public class ExampleFacade extends EntityServiceFacade<Example, ExampleFilter, ExampleService, ExampleDto, ExampleDto.Properties, ExampleMapper> {
}
```
## Controller
Przykładowa implementacja kontrolera
```java
@RestController
@RequestMapping("/example")
@RequiredArgsConstructor
public class UserController implements InitializingBean {
    private final ExampleFacade exampleFacade;
    private final MappingService mappingService;

    private MappingProperties defaultSingleProperties;
    private MappingProperties defaultListProperties;

    @Override
    public void afterPropertiesSet() throws Exception {
        defaultSingleProperties = mappingService.createProperties(UserDto.Properties.class)
                .setIncludeNestedExample(true); // zagnieżdżona encja zostanie zmapowana
        defaultListProperties = mappingService.createProperties(UserDto.Properties.class)
                .setIncludeNestedExample(false); // zagnieżdżona encja nie zostanie zmapowana
    }
}
```
### Endpointy
Aby wystawić endpoint należy oznaczyć metodę andotacją na przykład `@GetMapping`, `@PostMapping` etc. \
```java
@PutMapping("/{id}")
public ResponseEntity<ExampleDto> update(@PathVariable UUID id, @RequestBody ExampleDto dto) {
    return ResponseEntity.ok(exampleFacade.update(id, dto), defaultSingleProperties);    
}
```
Powyższy przykład wystawi endpoint przymujący parametr `id` w URLu i obiekt w `body` żądania. Następnie wykonta polecenie i zwróci `ExampleDto`