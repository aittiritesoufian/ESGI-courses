<?php
class User extends BaseSQL{

	protected $id = null;
	protected $firstname;
	protected $lastname;
	protected $email;
	protected $pwd;
	protected $token;
	protected $status = 0;//flag (delete,activate,banned,...)

    public function getId()
    {
        return $this->id;
    }

    public function setId($id)
    {
        $this->id = $id;
    }

    public function getFirstname()
    {
        return $this->firstname;
    }

    public function setFirstname($firstname)
    {
        $this->firstname = ucfirst(strtolower(trim($firstname)));
    }

    public function getLastname()
    {
        return $this->lastname;
    }

    public function setLastname($lastname)
    {
        $this->lastname = strtoupper(trim($lastname));
    }

    public function getPwd()
    {
        return $this->pwd;
    }

    public function setPwd($pwd)
    {
        $this->pwd = $pwd;//password_hash($pwd, PASSWORD_DEFAULT);
    }

    public function getToken()
    {
        return $this->token;
    }

    public function setToken($token = null)
    {
    	if($token){
    		$this->token = $token;
    	} else if(!empty($this->email)){
    		$this->token = substr(sha1("GDHJHkfjdfkjhdhs".$this->email.substr(time(), 5).uniqid()."dsfdsf"),2,10);
    	} else {
    		//renvoyer une erreur 500 avec un message en log.
    		die("Veuillez préciser un email");
    	}

    }

    public function getStatus()
    {
        return $this->status;
    }

    public function setStatus($status)
    {
        $this->status = $status;
    }

    public function getEmail()
    {
        return $this->email;
    }

    public function setEmail($email)
    {
        $this->email = strtolower(trim($email));
    }
}