package payroll;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
class PaydocsController {

	private final PaydocsRepository repository;

	PaydocsController(PaydocsRepository repository) {
		this.repository = repository;
	}

	// Aggregate root

	// tag::get-aggregate-root[]
	@GetMapping("/paydocs")
	CollectionModel<EntityModel<PayDocs>> all() {

		List<EntityModel<PayDocs>> employees = repository.findAll().stream()
				.map(PayDocs -> EntityModel.of(PayDocs,
						linkTo(methodOn(PaydocsController.class).one(PayDocs.getId())).withSelfRel(),
						linkTo(methodOn(PaydocsController.class).all()).withRel("paydocs")))
				.collect(Collectors.toList());

		return CollectionModel.of(employees, linkTo(methodOn(PaydocsController.class).all()).withSelfRel());
	}
	// end::get-aggregate-root[]

	@PostMapping("/paydocs")
	PayDocs newPaydoc(@RequestBody PayDocs newPaydoc) {
		return repository.save(newPaydoc);
	}

	// Single item

	// tag::get-single-item[]
	@GetMapping("/paydocs/{id}")
	EntityModel<PayDocs> one(@PathVariable Long id) {

		PayDocs PayDocs = repository.findById(id) //
				.orElseThrow(() -> new PaydocNotFoundException(id));

		return EntityModel.of(PayDocs, //
				linkTo(methodOn(PaydocsController.class).one(id)).withSelfRel(),
				linkTo(methodOn(PaydocsController.class).all()).withRel("paydocs"));
	}
	// end::get-single-item[]

	@PutMapping("/paydocs/{id}")
	PayDocs replaceEmployee(@RequestBody PayDocs newPaydoc, @PathVariable Long id) {

		return repository.findById(id) //
				.map(PayDocs -> {
					PayDocs.setId(newPaydoc.getId());
					return repository.save(PayDocs);
				}) //
				.orElseGet(() -> {
					newPaydoc.setId(id);
					return repository.save(newPaydoc);
				});
	}

	@DeleteMapping("/paydocs/{id}")
	void deleteEmployee(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
