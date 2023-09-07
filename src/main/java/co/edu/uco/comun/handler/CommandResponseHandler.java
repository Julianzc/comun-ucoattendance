package co.edu.uco.comun.handler;

import org.springframework.transaction.annotation.Transactional;

public interface CommandResponseHandler<C, R>{
    @Transactional
    R execute(C command);
}
