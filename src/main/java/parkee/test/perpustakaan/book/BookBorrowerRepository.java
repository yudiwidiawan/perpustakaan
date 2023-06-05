package parkee.test.perpustakaan.book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookBorrowerRepository extends JpaRepository<BookBorrowers, Long>{
    
}
