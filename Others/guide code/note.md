```sql
select S.SHEET_ID
        , S.CONTROL_SHEET_ID
        , S.END_LINE_HEADER
        , S.TYPE
        , S.LAST_PERIOD_NAME
        , S.TITLE
        , S.PREFIX
        , S.CREATE_DTTM
        , S.UPDATE_DTTM
        , S.CREATE_USER
        , S.UPDATE_USER
        , S.DELETE_FLAG
    from TBL_SHEET as S
        inner join TBL_CONTROL_SHEET as CS
            on S.CONTROL_SHEET_ID = CS.CONTROL_SHEET_ID
            and CS.CONTROL_SHEET_ID = 'C0000000000000000086'
            and CS.DELETE_FLAG = 0
        where S.DELETE_FLAG = 0
            and S.TYPE = 3
---

select DI.DISCLOSURE_ID, DI.DOCUMENT_NO, DI.ITEM_NAME, DI.ROW_TYPE, DI.SORT_ORDER, DI.LEVEL, DI.CONFIRMATION_METHOD
        , CS.STATUS as CONTROL_SHEET_STATUS
        , GROUP_CONCAT(CONCAT(BD.BASIC_ID
                                , ','
                                , case when BD.DOCUMENT_CD is null
                                        or BD.DOCUMENT_CD = ''
                                    then 'NULL'
                                    else BD.DOCUMENT_CD end
                                , ','
                                , case when BD.SUBMIT_SCHEDULE_DATE is not null
                                    then BD.SUBMIT_SCHEDULE_DATE
                                    else 'NULL' end
                                , ','
                                , case when RE.GETTING_DATE is not null
                                    then RE.GETTING_DATE
                                    else 'NULL' end
                    ) order by BD.SORT_ORDER separator ';') as BASIC_DOCUMENT
        , GROUP_CONCAT(CONCAT(HS.HEARING_SHEET_ID
                                , ':'
                                , case when HS.NUMBERING_DISPLAY is null
                                        or HS.NUMBERING_DISPLAY = ''
                                    then 'NULL'
                                    else HS.NUMBERING_DISPLAY end
                                , ':'
                                , case when HS.NUMBERING_TYPE is null
                                        or HS.NUMBERING_TYPE
                                        then 'NULL'
                                        else  HS.NUMBERING_TYPE end
                                , ':'
                                , HS.NUMBERING_VALUE
                                    ) order by HS.SORT_ORDER separator ';') as HEARING_SHEET
        , GROUP_CONCAT(CONCAT(DI2.DISCLOSURE_ID
                                , ','
                                , case when DI2.DOCUMENT_NO is null
                                        or DI2.DOCUMENT_NO = ''
                                    then 'NULL'
                                    else DI2.DOCUMENT_NO end
                    ) order by DI2.SORT_ORDER separator ';') as DISCLOSURE_SUMMARY
        , GROUP_CONCAT(CONCAT(DI3.DISCLOSURE_ID
                                , ','
                                , case when DI3.DOCUMENT_NO is null
                                        or DI3.DOCUMENT_NO = ''
                                    then 'NULL'
                                    else DI3.DOCUMENT_NO end
                    ) order by DI3.SORT_ORDER separator ';') as DISCLOSURE_FINANCIAL
        , CL.NAME as CLIENT_NAME
        , AP.TARGET_MONTH
        , AP.TARGET_YEAR
        , S.PREFIX as DISCLOSURE_REPORT_PREFIX
        , S1.PREFIX as BASIC_PREFIX
        , S2.PREFIX as DISCLOSURE_SUMMARY_PREFIX
        , S3.PREFIX as DISCLOSURE_FINANCIAL_PREFIX
    from TBL_DISCLOSURE_ITEM as DI
        inner join TBL_SHEET as S
            on DI.SHEET_ID = S.SHEET_ID
            and S.TYPE = 3
            and S.DELETE_FLAG = 0
        inner join TBL_CONTROL_SHEET as CS
            on CS.CONTROL_SHEET_ID = S.CONTROL_SHEET_ID
            and CS.TYPE = 2
            and CS.DELETE_FLAG = 0
        left join TBL_ACCOUNTING_PERIOD as AP
            on CS.CONTROL_SHEET_ID = AP.CONTROL_SHEET_ID
            and AP.DELETE_FLAG = 0
        left join TBL_CLIENT as CL
            on AP.CLIENT_ID = CL.CLIENT_ID
            and CL.DELETE_FLAG = 0
        left join TBL_REFERENCE_DOCUMENT as RD
            on DI.DISCLOSURE_ID = RD.DISCLOSURE_REPORT_ID
            and RD.DELETE_FLAG = 0
        left join TBL_BASIC_DOCUMENT as BD
            on RD.BASIC_ID = BD.BASIC_ID
            and BD.DELETE_FLAG = 0
        left join TBL_SHEET as S1
            on CS.CONTROL_SHEET_ID = S1.CONTROL_SHEET_ID
            and S1.TYPE = 1
            and S1.DELETE_FLAG = 0
        left join TBL_SHEET as S2
            on CS.CONTROL_SHEET_ID = S2.CONTROL_SHEET_ID
            and S2.TYPE = 2
            and S2.DELETE_FLAG = 0
        left join TBL_SHEET as S3
            on CS.CONTROL_SHEET_ID = S3.CONTROL_SHEET_ID
            and S3.TYPE = 4
            and S3.DELETE_FLAG = 0
        left join TBL_HEARING_SHEET as HS
            on RD.HEARING_SHEET_ID = HS.HEARING_SHEET_ID
            and HS.LEVEL =3
            and HS.DELETE_FLAG = 0
        left join TBL_DISCLOSURE_ITEM as DI2
            on RD.DISCLOSURE_SUMMARY_ID = DI2.DISCLOSURE_ID
            and DI2.DELETE_FLAG = 0
        left join TBL_DISCLOSURE_ITEM as DI3
            on RD.DISCLOSURE_FINANCIAL_ID = DI3.DISCLOSURE_ID
            and DI3.DELETE_FLAG = 0
        left join (
            select RD1.BASIC_ID, max(RD1.GETTING_DATE) as GETTING_DATE from TBL_REFERENCE_DOCUMENT AS RD1
                                        where RD1.REFERENCE_TYPE = 7
                                        and RD1.DELETE_FLAG = 0
                                        group by RD1.BASIC_ID
        ) as RE on RE.BASIC_ID = RD.BASIC_ID
        where DI.SHEET_ID = 'S0000000000000000481'
            and DI.DELETE_FLAG = 0
        group by DI.DISCLOSURE_ID, CL.NAME, AP.TARGET_MONTH, AP.TARGET_YEAR, BASIC_PREFIX, DISCLOSURE_SUMMARY_PREFIX, DISCLOSURE_FINANCIAL_PREFIX
        order by DI.DISCLOSURE_ID
-------------------------------------

select *  from TBL_DISCLOSURE_ITEM as DI
        inner join TBL_SHEET as S
            on DI.SHEET_ID = S.SHEET_ID
            and S.TYPE = 3
            and S.DELETE_FLAG = 0
        inner join TBL_CONTROL_SHEET as CS
            on CS.CONTROL_SHEET_ID = S.CONTROL_SHEET_ID
            and CS.TYPE = 2
            and CS.DELETE_FLAG = 0
        left join TBL_ACCOUNTING_PERIOD as AP
            on CS.CONTROL_SHEET_ID = AP.CONTROL_SHEET_ID
            and AP.DELETE_FLAG = 0
        left join TBL_CLIENT as CL
            on AP.CLIENT_ID = CL.CLIENT_ID
            and CL.DELETE_FLAG = 0
		where DI.SHEET_ID = 'S0000000000000000481'
            and DI.DELETE_FLAG = 0

-----------------------------------
Them vao TBL_REFERENCE_DOCUMENT o cot DISCLOSURE_REPORT_ID la ID da select ra




```

```json
{
  "disclosure_report": [
    {
      "id": "I0000000000000027864",
      "document_no": 242,
      "name": "固定資産の減価償却の方法",
      "revision_issues": false,
      "comment": "固定資産の減価償却の方法",
      "confirmation_method": ["H0000000000000003398", "H0000000000000003400"],
      "confirmation_method_note": "更新文書",
      "previous_period_disclosure_class": 2,
      "current_period_disclosure_class": 1,
      "disclosure_summary": ["I0000000000000026491", "I0000000000000027865"],
      "disclosure_financial": ["I0000000000000026488", "I0000000000000027863"],
      "basic_document": ["B0000000000000003487", "B0000000000000003489"],
      "create_status": false,
      "deadline": null,
      "complete_date": null,
      "posting_status": true,
      "row_type": 1,
      "sort_order": 1,
      "level": 1
    }
  ]
}

------- quatequarrsummary update ------------

```

---

```sql
------- quatequarrsummary update ------------
select S.SHEET_ID
        , S.CONTROL_SHEET_ID
        , S.END_LINE_HEADER
        , S.TYPE
        , S.LAST_PERIOD_NAME
        , S.TITLE
        , S.PREFIX
        , S.CREATE_DTTM
        , S.UPDATE_DTTM
        , S.CREATE_USER
        , S.UPDATE_USER
        , S.DELETE_FLAG
    from TBL_SHEET as S
        inner join TBL_CONTROL_SHEET as CS
            on S.CONTROL_SHEET_ID = CS.CONTROL_SHEET_ID
            and CS.CONTROL_SHEET_ID = 'C0000000000000000088'
            and CS.TYPE = 1
            and CS.DELETE_FLAG = 0
        where S.DELETE_FLAG = 0
            and S.TYPE = 2

```

https://www.techiedelight.com/split-string-java-using-dot-delimiter/
http://www.java2s.com/Code/Java/
https://howtodoinjava.com/java/string/4-ways-to-split-tokenize-strings-in-java/

#### doma

https://doma.readthedocs.io/en/stable/sql/

#### spring

@Controller

```java
@RestController
@RequestMapping(path="/client")
public class ClientController {
    @Autowired
    private HttpServletRequest httpServletRequest;

    @PutMapping(path = "/{clientId}")
        public ResponseEntity<?> update(@PathVariable String clientId, @RequestParam(required = false) Boolean checkControlSheet, @Validated @RequestBody ClientDto dto, BindingResult errorResult)  {
            dto.userId = httpServletRequest.getHeader(CommonConstant.USER_ID);
            dto.id = clientId;
            if (errorResult.hasErrors()) {
                return ResponseEntity.badRequest().body(Error.of(errorResult));
            }
            boolean controlSheetExist = clientService.update(dto, checkControlSheet);
            Map<String, Boolean> map = new HashMap<>();
            map.put(ClientConstant.CONTROL_SHEET_EXIST, controlSheetExist);
            return ResponseEntity.ok().body(map);
            // return ResponseEntity.ok().build(); // Khong return body
        }

        @GetMapping
        public ResponseEntity<Clients> find(
                @RequestParam(required = false) String name,
                @RequestParam(required = false) String  page,
                @RequestParam(required = false) String  itemPerPage,
                @RequestParam(required = false) String sortKey,
                @RequestParam(required = false) String sortDirection) throws BadRequestException {
            String userId = httpServletRequest.getHeader(CommonConstant.USER_ID);
            Clients clients = clientService.findBySearch(name, sortKey, sortDirection, page, itemPerPage, userId);
            return new ResponseEntity<>(clients, HttpStatus.OK);
        }

        @GetMapping(path = "/{id}")
        public ResponseEntity<ClientDto> get(@PathVariable("id") String clientId) {
            ClientDto entity = clientService.find(clientId);
            return ResponseEntity.ok(entity);
        }

        @PostMapping
        public ResponseEntity<?> insert(@Validated @RequestBody ClientDto dto, BindingResult errorResult) {

            // get header
            dto.userId = httpServletRequest.getHeader(CommonConstant.USER_ID);
            if (errorResult.hasErrors()) {
                return ResponseEntity.badRequest().body(Error.of(errorResult));
            }
            clientService.insert(dto);
            return ResponseEntity.ok().build();
        }
    }
```

validate
NotBlankValidator

```java

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;

import vn.rikkeisys.controlsheet.presentation.validator.annotation.NotBlank;

public class NotBlankValidator implements ConstraintValidator<NotBlank, String>{
    @Override
    public void initialize(NotBlank constraintAnnotation) {}

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !StringUtils.isBlank(value);
    }
}
--
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import vn.rikkeisys.controlsheet.presentation.validator.NotBlankValidator;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotBlankValidator.class)
public @interface NotBlank {
    String message() default "{vn.rikkeisys.controlsheet.presentation.validator.annotation.NotBlank.message}";

    String fieldName() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
```

---

JPA and all
https://www.logicbig.com/tutorials/java-ee-tutorial/jpa/entity-audit-listener.html
https://www.logicbig.com/tutorials/spring-framework/spring-core/configuration-metadata.html
https://www.javacodegeeks.com/2013/10/spring-injected-beans-in-jpa-entitylisteners.html
https://docs.jboss.org/hibernate/core/4.0/hem/en-US/html/listeners.html

@Autowired

- neu them final se khong su dung duoc => use constructor injection

#### java 8

collectingAndThen
https://www.geeksforgeeks.org/collectors-collectingandthen-method-in-java-with-examples/
https://www.techiedelight.com/collectors-collectingandthen-method-java/
https://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/

```java
// Filter
entites.stream().map(File::fromEntity).filter(Objects::nonNull).collect(Collectors.toList())

RandomStringUtils.randomAlphabetic(16);
essageDigest.getInstance("MD5");
```

https://portal.liferay.dev/docs/6-2/tutorials/-/knowledge_base/t/developing-apps-with-liferay-ide

https://portal.liferay.dev/docs/6-1/develop/-/knowledge_base/t/installation
https://sourceforge.net/projects/lportal/files/Liferay%20IDE/3.0.1%20GA2/liferay-ide-eclipse-windows-x64-3.0.1-ga2-201606151031.zip/download

---
