package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Policy;
import com.exception.PolicyNotFoundException;
import com.repository.PolicyRepository;



@Service
public class PolicyService {
    @Autowired
    private PolicyRepository policyRepository;

	public Policy savePolicy(Policy policy) {
		return policyRepository.save(policy);
	}
	
    public List<Policy> getAllPolicies() {
        return policyRepository.findAll();
    }
    public List<Policy> getByIds(List<Long> plist) {
		return (List<Policy>)policyRepository.findAllById(plist);	
		
	}
    public Policy getPolicyById(Long policyId) {
        return policyRepository.findById(policyId)
            .orElseThrow(() -> new PolicyNotFoundException("Policy not found with ID: " + policyId));
    }
    
	public Policy updatePolicy(Policy policy, long id) {
		
		Policy existingPolicy = policyRepository.findById(id).orElseThrow(
				() -> new PolicyNotFoundException(id));
		
		existingPolicy.setPolicy_name(policy.getPolicy_name());
		existingPolicy.setPolicy_description(policy.getPolicy_description());
		existingPolicy.setStandardPremium(policy.getStandardPremium());
		existingPolicy.setCoverageAmount(policy.getCoverageAmount());
		existingPolicy.setTerm(policy.getTerm());
		
		policyRepository.save(existingPolicy);
		return null;
	}


	public void deletePolicy(long id) {
		// TODO Auto-generated method stub
		policyRepository.findById(id).orElseThrow(
				() -> new PolicyNotFoundException(id));

		policyRepository.deleteById(id);
		
		
	}



}