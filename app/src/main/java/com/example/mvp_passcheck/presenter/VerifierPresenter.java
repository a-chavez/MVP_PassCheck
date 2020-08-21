package com.example.mvp_passcheck.presenter;

import com.example.mvp_passcheck.model.Verifier;

public class VerifierPresenter implements IPresenter{

    private Verifier verifier;   //tener una variable del modelo (implementacion de la clase Verifier)
    private IViewPresenter view; //tener una variable de la vista (implementacion)

    //requiere instanciar (se usa un constructor) usar alt+insert
    public VerifierPresenter(IViewPresenter view) {
        this.view = view;
        verifier = new Verifier();  // se instancia la variable revifier
    }

    @Override
    public void evaluatePass(String password) {
        int res = verifier.evaluatePass(password);
        switch (res){
            case Verifier.WEAK:
                this.view.showWeak();
                break;
            case Verifier.MEDIUM:
                this.view.showMedium();
                break;
            case Verifier.STRONG:
                this.view.showStrong();
                break;
        }

    }
}
