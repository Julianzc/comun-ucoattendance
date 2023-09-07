package co.edu.uco.comun.handler;

import org.springframework.transaction.annotation.Transactional;

public interface CommandHandler<C>{
    @Transactional
    void execute(C command);
}
